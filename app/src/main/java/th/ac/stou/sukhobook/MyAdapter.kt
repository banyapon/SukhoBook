package th.ac.stou.sukhobook

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.book_item.view.*

class MyAdapter(val postList: List<Magazine>, val context: Context?) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.book_item, parent, false))
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.txtPostTitle.text = postList[position].title
        holder.itemView.txtPostBody.text = postList[position].authors
        holder.itemView.txtPrice.text = "ราคา: "+postList[position].price.toString()+" บาท"
        Picasso.get().load(postList[position].imagelUrl)
            .error(R.mipmap.ic_launcher)
            .placeholder(R.mipmap.ic_launcher)
            .into(holder.itemView.imageView);

        holder.itemView.cardView.setOnClickListener(View.OnClickListener { v ->
            Toast.makeText(v.getContext(), "ISBN: "+postList[position].isbn, Toast.LENGTH_SHORT).show();
        })
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
