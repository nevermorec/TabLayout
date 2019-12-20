package com.example.tablayouttest


import android.animation.ObjectAnimator
import android.content.ContentResolver
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_ratate.*
import kotlinx.android.synthetic.main.fragment_scale.*
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 */
class RatateFragment : Fragment() {
    public lateinit var contactsList: ArrayList<Person>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ratate, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        contactsList = ArrayList<Person>()
        val myAdapter = MyAdapter()
        recyclerViewContacts.apply {
            adapter = myAdapter
            layoutManager = GridLayoutManager(requireContext(), 1)
        }
        readContacts()
        myAdapter.submitList(contactsList)

    }

    private fun readContacts() {
        Log.d("Main", "start")
        val cursor:Cursor
        try {
            cursor = requireContext().contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null, null, null, null)!!
            while (cursor.moveToNext()) {
                val person = Person(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)),
                    cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)))
                contactsList.add(person)
            }
        } catch (e: Exception) {
            Log.d("Main", e.toString())
            e.printStackTrace()
        }
    }

}
