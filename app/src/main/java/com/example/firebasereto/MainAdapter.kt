package com.example.firebasereto

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasereto.databinding.ItemMovieBinding
import org.json.JSONArray
import org.json.JSONObject
import java.util.*

class MainAdapter(private val movies: JSONArray): RecyclerView.Adapter<MainAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        if(movies[position].toString() == "null"){
            Log.e("json123","Entra")
        }else{
            holder.render(movies[position] as JSONObject)
        }


    }

    override fun getItemCount(): Int = movies.length()

    class MainHolder(val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root){
        fun render(movie: JSONObject){
            binding.tvMovieCountry.setText(movie.getString("country"))
            binding.tvMovieYear.setText(movie.getString("year"))
            binding.tvMovieIMDBID.setText(movie.getString("imdbid"))
            binding.tvMovieGenre.setText(movie.getString("genre"))
            binding.tvMovieTitle.setText(movie.getString("title"))
            binding.tvMovieType.setText(movie.getString("type"))
            binding.ivMovie.setImageResource(R.drawable.placeholder_movie)
        }
    }


}