package com.svmglobal.wrkitdemo.ui.offers

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.svmglobal.wrkitdemo.R

class OffersAdapter (private val dataset: Array<String>) :
    RecyclerView.Adapter<OffersAdapter.OffersViewHolder>() {

    class OffersViewHolder(val linearLayout: LinearLayout) : RecyclerView.ViewHolder(linearLayout) {
        var imageSource = ""

//        fun updateWithUrl(url: String) {
//            imageSource = url
//            Picasso.get().load(url).into(imageView)
//        }

//        fun bind(item: String){
//            imageView.setOnClickListener(this)
//        }

//        override fun onClick(view: View) {
//            val intent = Intent(view.context, CardDetailsActivity::class.java)
//            intent.putExtra("product", imageSource)
//            view.context.startActivity(intent)
//        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): OffersViewHolder {
        // create a new view
        val imageView = LayoutInflater.from(parent.context)
            .inflate(R.layout.offer_row_item, parent, false) as LinearLayout

        return OffersViewHolder(imageView)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: OffersViewHolder, position: Int) {
        val imageUrl = dataset[position]
//        holder.updateWithUrl(imageUrl)
//        holder.bind(dataset[position])
    }

    override fun getItemCount() = dataset.size
}