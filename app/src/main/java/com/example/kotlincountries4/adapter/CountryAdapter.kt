package com.example.kotlincountries4.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincountries4.R
import com.example.kotlincountries4.databinding.ItemCountryBinding
import com.example.kotlincountries4.model.Country
import com.example.kotlincountries4.util.downloadFromUrl
import com.example.kotlincountries4.util.placeholderProgressBar
import com.example.kotlincountries4.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter(private val countryList: ArrayList<Country>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(), CountryClickListener {

    class CountryViewHolder(var view: ItemCountryBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        //val view = inflater.inflate(R.layout.item_country, parent, false)
        val view = DataBindingUtil.inflate<ItemCountryBinding>(inflater, R.layout.item_country, parent, false)

        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        holder.view.country = countryList[position]
        holder.view.listener = this

        /*
        holder.view.name.text = countryList[position].countryName
        holder.view.region.text = countryList[position].countryRegion

        holder.view.setOnClickListener {
            val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment(countryList[position].uuid)
            Navigation.findNavController(it).navigate(action)
        }

        holder.view.imageView.downloadFromUrl(countryList[position].imageUrl, placeholderProgressBar(holder.view.context))

         */
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    fun updateCountryList(newCountryList: List<Country>){
        countryList.clear()
        countryList.addAll(newCountryList)

        notifyDataSetChanged()
    }

    override fun onCountryClicked(view: View) {
        val uuid = view.countryUuidText.text.toString().toInt()
        val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment(uuid)
        Navigation.findNavController(view).navigate(action)
    }

}