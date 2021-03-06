package com.example.faby.coderswag.Controller

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.example.faby.coderswag.Adapters.ProductsAdapter
import com.example.faby.coderswag.R
import com.example.faby.coderswag.Services.DataService
import com.example.faby.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter: ProductsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductsAdapter(this, DataService.getProducts(categoryType))

        var spanCount = 2
        val orientation = resources.configuration.orientation
        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 3
        }

        val screenSize = resources.configuration.screenWidthDp
        if(screenSize > 720){
            spanCount = 3
        }


        val layoutManger = GridLayoutManager(this, spanCount)
        productListView.layoutManager = layoutManger
        productListView.adapter = adapter

    }
}
