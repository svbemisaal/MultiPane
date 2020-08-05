package com.example.multipaneview

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val  ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentOptional.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentOptional : Fragment() {


    interface OnOptionClickListener {
        fun onOptionSelected(option: String?)
    }

    private var mCallback: OnOptionClickListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mCallback = try {
            context as OnOptionClickListener
        } catch (e: Exception) {
            throw ClassCastException("$context must implement SettingOptionsFragment.OnOptionClickListener")
        }
    }

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val rootview: View = inflater.inflate(R.layout.fragment_optional, container, false)


        val frontend: LinearLayout = rootview.findViewById(R.id.frontendOption)
        val backend: LinearLayout = rootview.findViewById(R.id.backendOption)
        val database: LinearLayout = rootview.findViewById(R.id.databasekOption)


        frontend.setOnClickListener(View.OnClickListener {

            fun onClick(v: View) {
                mCallback?.onOptionSelected("frontend")
            }
        })


        backend.setOnClickListener(View.OnClickListener {
            fun onClick(v: View) {
                mCallback?.onOptionSelected("backend")
            }
        })


        database.setOnClickListener(View.OnClickListener {

            fun onClick(v: View) {
                mCallback?.onOptionSelected("database")
            }
        })
        return rootview
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentOptional.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentOptional().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}