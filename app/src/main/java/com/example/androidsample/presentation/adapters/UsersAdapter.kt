package com.example.androidsample.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidsample.R
import com.example.androidsample.data.pojo.User
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.item_user.view.*

class UsersAdapter(
    private val onItemClick: (User, view: View) -> Unit
) : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    private var items: MutableList<User> = mutableListOf()

    internal fun setNewItems(items: MutableList<User>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = items[position]
        holder.itemView.setOnClickListener {
            onItemClick(user, holder.itemView.userImageView)
        }
        holder.bind(user)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) = with(itemView) {
            //userImageView.setImageResource(user.image)
            userImageView.transitionName = user.id
            userNameTextView.text = user.name
        }
    }
}