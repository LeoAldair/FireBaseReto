package com.example.firebasereto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.firebasereto.databinding.FragmentHomeBinding
import com.example.firebasereto.databinding.FragmentInsertBinding
import com.google.firebase.ktx.Firebase
import com.google.firebase.database.ktx.database

class InsertFragment : Fragment() {
    private lateinit var binding: FragmentInsertBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInsertBinding.inflate(layoutInflater)
        val navController = findNavController()
        binding.btnInsertMovie.setOnClickListener {
            val database = Firebase.database
            val myRef = database.reference
            val id = binding.etMovieID.text.toString()
            val title = binding.etMovieTitle.text.toString()
            val year = binding.etMovieYear.text.toString()
            val genre = binding.etMovieGenre.text.toString()
            val country = binding.etMovieCountry.text.toString()
            val type = binding.etTypeMovie.text.toString()
            val imdbid = binding.etMovieimdbID.text.toString()
            myRef.child("Movies").child(id).setValue(Movie(id, title,year, genre, country,type,imdbid))
            navController.navigate(R.id.action_insertFragment_to_homeFragment)
        }
        return binding.root
    }

}