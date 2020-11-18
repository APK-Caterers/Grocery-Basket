package com.google.codelabs.mdc.java.shrine;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.codelabs.mdc.java.shrine.network.ImageRequester;
import com.google.codelabs.mdc.java.shrine.network.ProductEntry;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import static android.content.ContentValues.TAG;

/**
 * Adapter used to show a simple grid of products.
 */
public class ProductCardRecyclerViewAdapter extends RecyclerView.Adapter<ProductCardViewHolder> {

    private List<ProductEntry> productList;
    private ImageRequester imageRequester;

    ProductCardRecyclerViewAdapter(List<ProductEntry> productList) {
        this.productList = productList;
        imageRequester = ImageRequester.getInstance();
    }

    @NonNull
    @Override
    public ProductCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shr_product_card, parent, false);
        return new ProductCardViewHolder(layoutView);
    }


    @Override
    public void onBindViewHolder(@NonNull final ProductCardViewHolder holder, final int position) {
        DocumentReference mDocRef = FirebaseFirestore.getInstance().collection("products").document("Vegetables_and_fruits");
        mDocRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists() || productList != null || position < productList.size())
                {
                    final String TAG="Adit";
                    Log.d(TAG,"Document has been saved");
                    holder.productTitle.setText(documentSnapshot.getString("title"));
                    holder.productPrice.setText(documentSnapshot.getString("Price"));
                    holder.AddToCart.setText(R.string.button_text2);
                    imageRequester.setImageFromUrl(holder.productImage, documentSnapshot.getString("url"));
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                final String TAG="Adit";
                Log.w(TAG,"Could not retrieve Document");
            }
        });
        /*if (productList != null && position < productList.size()) {
            ProductEntry product = productList.get(position);
            holder.productTitle.setText(product.title);
            holder.productPrice.setText(product.price);
            holder.AddToCart.setText(R.string.add_to_cart);
            imageRequester.setImageFromUrl(holder.productImage, product.url);
        }*/
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
