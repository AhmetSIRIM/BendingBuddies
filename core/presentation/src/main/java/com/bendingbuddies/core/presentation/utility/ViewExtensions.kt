package com.bendingbuddies.core.presentation.utility

import android.text.Editable
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import coil.load
import coil.size.Scale
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.onStart

fun AppCompatImageView.loadImage(imageUrl: String) {
    load(imageUrl) {
        scale(Scale.FILL)
    }
}

fun AppCompatEditText.observeTextChanges(): Flow<String> {

    return callbackFlow {

        val textWatcher = object : com.bendingbuddies.core.presentation.contract.AbstractTextWatcher() {
            override fun afterTextChanged(s: Editable?) {
                super.afterTextChanged(s)
                trySend(s.toString())
            }
        }

        addTextChangedListener(textWatcher)

        awaitClose {
            removeTextChangedListener(textWatcher)
        }

    }.onStart {
        text?.let {
            emit(it.toString())
        }
    }

}