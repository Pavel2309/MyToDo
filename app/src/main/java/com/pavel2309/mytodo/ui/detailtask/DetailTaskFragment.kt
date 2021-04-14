package com.pavel2309.mytodo.ui.detailtask

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.pavel2309.mytodo.R
import com.pavel2309.mytodo.databinding.FragmentDetailTaskBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailTaskFragment : Fragment(R.layout.fragment_detail_task) {

    private val viewModel: DetailTaskViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentDetailTaskBinding.bind(view)

        binding.apply {
            editTextTaskName.setText(viewModel.taskName)
            checkboxImportant.isChecked = viewModel.taskImportance
            checkboxImportant.jumpDrawablesToCurrentState()
            textViewDateCreated.isVisible = viewModel.task != null
            textViewDateCreated.text = "Created: ${viewModel.task?.timeCreatedDateFormatted}"
        }
    }

}