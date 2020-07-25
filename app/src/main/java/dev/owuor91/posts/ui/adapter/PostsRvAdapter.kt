package dev.owuor91.posts.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.owuor91.domain.models.Post
import dev.owuor91.posts.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.row_post_list_item.view.*

class PostsRvAdapter() : RecyclerView.Adapter<PostsRvAdapter.PostViewholder>() {
    var data: List<Post> = emptyList()
        set(newList) {
            field = newList
        }

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewholder {
        return PostViewholder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_post_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PostsRvAdapter.PostViewholder, position: Int) {
        holder.bind(data[position])
    }

    inner class PostViewholder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        fun bind(item: Post) = with(itemView) {
            tvTitle.text = item.title
            tvBody.text = item.body
            tvUserId.text = "User Id: ${item.userId}"
        }
    }
}
