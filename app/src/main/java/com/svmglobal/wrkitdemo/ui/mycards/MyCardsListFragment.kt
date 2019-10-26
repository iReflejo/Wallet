package com.svmglobal.wrkitdemo.ui.mycards

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.getbouncer.cardscan.ScanActivity
import com.google.android.material.chip.Chip
import com.svmglobal.wrkitdemo.R
import com.svmglobal.wrkitdemo.services.InternalApiClient


class MyCardsListFragment : Fragment() {
    private lateinit var viewModel: MyCardsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProviders.of(activity!!)
                .get(MyCardsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_my_card_list, container, false)

        val viewManager = LinearLayoutManager(this.context)
        val viewAdapter = MyCardsAdapter(
            InternalApiClient.getAllCards(),
            viewModel
        )

        root.findViewById<RecyclerView>(R.id.my_cards_view)?.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        val chip = root.findViewById<Chip>(R.id.add_new_card)
        chip.setOnClickListener {
            ScanActivity.start(this.activity as Activity)
        }

        return root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (ScanActivity.isScanResult(requestCode)) {
            if (resultCode == ScanActivity.RESULT_OK && data != null) {
                val scanResult = ScanActivity.creditCardFromResult(data)

                // at this point pass the info to your app's enter card flow
                // this is how we do it in our example app
//                val intent = Intent(this.context, EnterCard::class.java)
//                intent.putExtra("card", scanResult)
//                startActivity(intent)
            } else if (resultCode == ScanActivity.RESULT_CANCELED) {
                Log.d("CC Scan", "The user pressed the back button")
            }
        }
    }


}