package com.svmglobal.wrkitdemo.ui.mycards

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cards.pay.paycardsrecognizer.sdk.Card
import cards.pay.paycardsrecognizer.sdk.ScanCardIntent
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
            val intent = ScanCardIntent.Builder(this.context).build()
            startActivityForResult(intent, 1445)
        }

        return root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1445) {
            if (resultCode == Activity.RESULT_OK) {
                val cardData = data!!.getParcelableExtra<Card>(ScanCardIntent.RESULT_PAYCARDS_CARD)

                val card = AddCardViewModel(
                    cardData!!.cardNumber,
                    cardData.expirationDate,
                    cardData.cardHolderName,
                    ""
                )
                val action = MyCardsFragmentDirections.actionNavigationCardsToAddCardFragment(card)
                findNavController().navigate(action)
            }
        }
    }

}