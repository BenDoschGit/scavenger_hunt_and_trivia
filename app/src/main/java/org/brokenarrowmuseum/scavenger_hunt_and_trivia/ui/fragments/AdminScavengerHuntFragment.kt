package org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.R
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.adapters.AdminTriviaAdapter
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.viewmodels.QuestionsViewModel

class AdminScavengerHuntFragment : Fragment() {

    private lateinit var viewModel : QuestionsViewModel
    private val adapter = AdminTriviaAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Initilaize the viewModel using the fragments view
        viewModel = ViewModelProvider(this).get(QuestionsViewModel::class.java)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trivia, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        viewModel.fetchQuestions()
        viewModel.questions.observe(viewLifecycleOwner, {
            adapter.setQuestions(it)
        })

        val rvTriva = view?.findViewById<RecyclerView>(R.id.rvTrivia)
        rvTriva?.adapter = adapter
        rvTriva?.layoutManager = LinearLayoutManager(activity)
    }
}