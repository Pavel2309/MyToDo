package com.pavel2309.mytodo.ui.tasks

import androidx.lifecycle.ViewModel
import com.pavel2309.mytodo.data.TaskDao
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor(
    private val taskDao: TaskDao
) : ViewModel() {
}