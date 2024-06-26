package com.example.sibarat.activity.dictionary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sibarat.R
import com.example.sibarat.data.Alphabet
import com.example.sibarat.databinding.ActivityDictionaryBinding

class DictionaryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDictionaryBinding
    private lateinit var rvAlphabet: RecyclerView
    private val list = ArrayList<Alphabet>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDictionaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvAlphabet = binding.rvDictionary
        rvAlphabet.setHasFixedSize(true)
        list.addAll(getListAlphabet())
        showRecyclerList()
        supportActionBar?.hide()
    }

    private fun getListAlphabet(): ArrayList<Alphabet> {
        val dataAlphabet = resources.getStringArray(R.array.data_alphabet)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listAlphabet = ArrayList<Alphabet>()
        for (i in dataAlphabet.indices) {
            val alphabet = Alphabet(dataAlphabet[i], dataPhoto.getResourceId(i, -1))
            listAlphabet.add(alphabet)
        }
        return listAlphabet
    }
    private fun showRecyclerList() {
        rvAlphabet.layoutManager = GridLayoutManager(this, 2)
        val adapter = DictionaryAdapter(list)
        rvAlphabet.adapter = adapter
    }

}