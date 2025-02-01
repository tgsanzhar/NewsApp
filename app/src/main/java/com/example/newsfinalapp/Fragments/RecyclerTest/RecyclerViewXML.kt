package com.example.newsfinalapp.Fragments.RecyclerTest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfinalapp.R
import com.example.newsfinalapp.databinding.RecyclerViewMyBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RecyclerViewXML : Fragment() {

    private var _binding: RecyclerViewMyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = RecyclerViewMyBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = adapterRecyclerView()
        binding.list.adapter = adapter
        binding.list.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        adapter.submitList(
            listOf(
                ChipItem(1, "Name1"),
                ChipItem(2, "Name2"),
                ChipItem(3, "Name3"),
                ChipItem(4, "Name4"),
                ChipItem(5, "Name5"),
                ChipItem(6, "Name6"),
                ChipItem(7, "Name7"),
                ChipItem(8, "Name8"),
                ChipItem(9, "Name9"),
                ChipItem(10, "Name10"),
            )
        )

        lifecycleScope.launch {
            delay(2_000)
            adapter.submitList(
                listOf(
                    ChipItem(0, "Name1"),
                    ChipItem(1, "Name2"),
                    ChipItem(2, "Name3"),
                    ChipItem(4, "Name4"),
                    ChipItem(8, "Name8"),
                    ChipItem(9, "Name9"),
                    ChipItem(10, "Name10"),
                    ChipItem(11, "Name10"),
                    ChipItem(12, "Name10"),
                    ChipItem(13, "Name10"),
                    ChipItem(14, "Name10"),
                    ChipItem(15, "Name10"),
                    ChipItem(16, "Name10"),
                    ChipItem(17, "Name10"),
                )
            )
            adapter.notifyDataSetChanged()
        }

        val adapterColumn = adapterRecyclerViewColumn()

        binding.list2.adapter = adapterColumn
        binding.list2.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapterColumn.submitList(
            listOf(
                ChipItem(1, "Name1"),
                ChipItem(2, "Name2"),
                ChipItem(3, "Name3"),
                ChipItem(4, "Name4"),
                ChipItem(5, "Name5"),
                ChipItem(6, "Name6"),
                ChipItem(7, "Name7"),
                ChipItem(8, "Name8"),
                ChipItem(9, "Name9"),
                ChipItem(10, "Name10"),
            )
        )

        lifecycleScope.launch {
            delay(2_000)
            adapterColumn.submitList(
                listOf(
                    ChipItem(0, "Name1"),
                    ChipItem(1, "Name2"),
                    ChipItem(2, "Name3"),
                    ChipItem(4, "Name4"),
                    ChipItem(8, "Name8"),
                    ChipItem(9, "Name9"),
                    ChipItem(10, "Name10"),
                    ChipItem(11, "Name10"),
                    ChipItem(12, "Name10"),
                    ChipItem(13, "Name10"),
                    ChipItem(14, "Name10"),
                    ChipItem(15, "Name10"),
                    ChipItem(16, "Name10"),
                    ChipItem(17, "Name10"),
                )
            )
            adapter.notifyDataSetChanged()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}