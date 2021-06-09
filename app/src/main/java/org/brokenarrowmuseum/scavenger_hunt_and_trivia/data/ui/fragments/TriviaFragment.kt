package org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.R
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.adapters.TriviaAdapter
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.entities.Question

class TriviaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trivia, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        val questionlist = mutableListOf<Question>(
            Question("1", "Open-ended", "Is this the real life?"),
            Question("2", "Open-ended", "Is this just fantasy?"),
            Question("3", "Open-ended", "Caught in a landslide"),
            Question("4", "Open-ended", "No escape from reality?"),
            Question("5", "Open-ended", "Open your eyes"),
            Question("6", "Open-ended", "Look up to the skies"),
            Question("7", "Open-ended", "and see!"),
            Question("8", "Open-ended", "I'm just a poor boy, nobody loves me, because it's easy come, easy go. Little high, little low. Anyway the wind blows doesn't even mater to meeeee. Tooooo meeeeeeee.")
        )

        val adapter = TriviaAdapter(questionlist)
        val rvTriva = view?.findViewById<RecyclerView>(R.id.rvTrivia)
        rvTriva?.adapter = adapter
        rvTriva?.layoutManager = LinearLayoutManager(activity)


            /** viewModel.fetchQuestions()

            viewModel.authors.observe(viewLifecycleOwner, {
            adapter.setQuestions(it)
            })*/
    }
}