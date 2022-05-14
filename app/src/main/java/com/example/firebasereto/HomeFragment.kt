package com.example.firebasereto

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.firebasereto.databinding.FragmentHomeBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import org.json.JSONArray
import org.json.JSONObject


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        val navController = findNavController()
        binding.btnInsertMovie.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_insertFragment)
        }
        val database = Firebase.database
        val myRef = database.reference
        myRef.child("Movies").get().addOnSuccessListener { response ->
            val fakeMovieData = JSONArray(response.value.toString())
            Log.e("json123", fakeMovieData.toString())
            binding.rvMovieEntries.adapter = MainAdapter(fakeMovieData)
        }.addOnFailureListener {
            Log.e("json123", "FATALError")
        }

        return binding.root
    }
}