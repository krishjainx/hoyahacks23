package com.ezyretirement.app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ezyretirement.app.databinding.RetirementStageItemBinding
import com.ezyretirement.app.ext.toUSD
import com.ezyretirement.app.models.RetirementStateModel

class RetirementStageListAdapter(
    private val retirementStageLists: List<RetirementStateModel>,
    private val context: Context
) : RecyclerView.Adapter<RetirementStageListAdapter.RetirementStateListViewHolder>() {


    inner class RetirementStateListViewHolder(private val item: RetirementStageItemBinding) :
        RecyclerView.ViewHolder(item.root) {
        fun setUpData(state: RetirementStateModel) {
            item.retirementAge.text = state.year.toString()
            item.salary.text = "Salary  ${state.salary.toUSD()}"
            item.contribution.text = "Contribution  ${state.contributionAmount.toUSD()}"
            item.retirementSavings.text = "Retirement Savings ${state.retirementSavings.toUSD()}"
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RetirementStateListViewHolder {
        return RetirementStateListViewHolder(
            RetirementStageItemBinding.inflate(
                LayoutInflater.from(
                    context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RetirementStateListViewHolder, position: Int) {
            holder.setUpData(retirementStageLists[position])
    }

    override fun getItemCount(): Int = retirementStageLists.size
}