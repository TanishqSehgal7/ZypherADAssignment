package com.example.zypheradassignment.SwipableDialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.net.Uri
import android.text.Layout
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.zypheradassignment.R


open class SwipableDialogClass() : DialogFragment() {

    companion object {

        fun CreateDialog(context: Context,title:String, image: Uri) {
            val view: View = LayoutInflater.from(context).inflate(R.layout.swipable_dialog_layout,null)
            val dialog=Dialog(context)
            val dialogTitle: TextView =view.findViewById(R.id.TvTitleDialog)
            val dialogImage: ImageView =view.findViewById(R.id.ImgDialog)
            dialogTitle.text=title
            dialogImage.setImageURI(image)
            dialog.setContentView(view)
            dialog.show()
        }
    }

//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//            val view:View=inflater.inflate(R.layout.swipable_dialog_layout,container,false)
//            return view
//        }
//
//    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//        val dialog=super.onCreateDialog(savedInstanceState)
//        dialog.requestWindowFeature(Window.FEATURE_SWIPE_TO_DISMISS)
//        return dialog
//    }

    }