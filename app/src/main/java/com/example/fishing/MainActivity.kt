package com.example.fishing

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    private lateinit var  recyclerView:RecyclerView
    private lateinit var  fishAdapter: ItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var naView = findViewById<NavigationView>(R.id.nav_view)
        naView.setNavigationItemSelectedListener (this)
         recyclerView = findViewById(R.id.rcView)
        var listItems = ArrayList<FishDescription>()

        fishAdapter = ItemAdapter(listItems,this)
       /* listItems.addAll(fillArrays(resources.getStringArray(R.array.fish),
            resources.getStringArray(R.array.fish_content),
            getImgId(R.array.fish_img_array)))
*/
        recyclerView.apply {
            hasFixedSize()
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = fishAdapter
        }

        
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.fish ->
            {
             Toast.makeText(this, "Fish", Toast.LENGTH_SHORT).show()
               fishAdapter.updateAdapter(fillArrays(resources.getStringArray(R.array.fish),
                   resources.getStringArray(R.array.fish_content),
                   getImgId(R.array.fish_img_array)))
            }

            R.id.sna ->
            {Toast.makeText(this, "Снасти", Toast.LENGTH_SHORT).show()

             fishAdapter.updateAdapter(fillArrays(resources.getStringArray(R.array.sna_f),
                 resources.getStringArray(R.array.sna_description),getImgId(R.array.img_sn)))
            }

            R.id.na -> {
                Toast.makeText(this, "Наживки", Toast.LENGTH_SHORT).show()
                fishAdapter.updateAdapter(fillArrays(resources.getStringArray(R.array.na_f),
                    resources.getStringArray(R.array.na_description),getImgId(R.array.img_na)))
            }
            R.id.histor -> Toast.makeText(this, R.string.history, Toast.LENGTH_SHORT).show()
        }
        return true
    }

    fun fillArrays(titleArray:Array<String>, contentArray:Array<String>,imgArray:IntArray):ArrayList<FishDescription>
    {
        var listItem = ArrayList<FishDescription>()
        for (n in 0 until titleArray.size)
        {
            var fishDescription  = FishDescription(imgArray[n],titleArray[n],contentArray[n])
            listItem.add(fishDescription)
        }
        return listItem
    }
    fun getImgId(imgArrayID:Int):IntArray
    {
        var tArray:TypedArray = resources.obtainTypedArray(imgArrayID)
        val count = tArray.length()
        val ids = IntArray(count)
        for(i in ids.indices)
        {
            ids[i] = tArray.getResourceId(i,0)

        }
        tArray.recycle()
        return ids
    }
}