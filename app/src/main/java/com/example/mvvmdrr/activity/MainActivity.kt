package com.example.mvvmdrr.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmdrr.adpter.ProductListAdapter
import com.example.mvvmdrr.app.ProductApp
import com.example.mvvmdrr.database.ProductDataBase
import com.example.mvvmdrr.databinding.ActivityMainBinding
import com.example.mvvmdrr.utils.ApiResponce
import com.example.mvvmdrr.utils.Utilities.Companion.isInternetConnection
import com.example.mvvmdrr.viewmodel.ProductViewModel
import com.example.mvvmdrr.viewmodel.ProductViewModelFactory
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    
    @Inject
    lateinit var productViewModelFactory: ProductViewModelFactory

    lateinit var viewModel: ProductViewModel

    @Inject
    lateinit var productListAdapter: ProductListAdapter

    @Inject
    lateinit var dataBase: ProductDataBase

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)
        ProductApp.productComponent.inject(this)
        
        viewModel = ViewModelProvider(this, productViewModelFactory)[ProductViewModel::class.java]

        
        viewModel.getProductData()
        if (isInternetConnection(this)){
            fetchDataFromViewModel()
        }else{
            MainScope().launch {
                dataBase.getDao().getAllProductFromDB().apply {
                    productListAdapter.submitList(this)
                    binding.apply {
                        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                        recyclerView.adapter = productListAdapter
                        recyclerView.hasFixedSize()
                        Log.d("DataComes", "Data comes from database")
                    }
                }
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun fetchDataFromViewModel() {
        viewModel.productLiveData.observe(this, Observer {
            when (it) {
                is ApiResponce.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is ApiResponce.Successful -> {
                    productListAdapter.submitList(it.apiData)
                    binding.apply {
                        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                        recyclerView.adapter = productListAdapter
                        recyclerView.hasFixedSize()
                        productListAdapter.notifyDataSetChanged()
                    }
                    binding.progressBar.visibility = View.INVISIBLE
                    Log.d("DataComes", "Data comes from network")
                }
                is ApiResponce.Error -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                    binding.progressBar.visibility = View.INVISIBLE
                }
            }
        })
    }
}