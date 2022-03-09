package com.example.mycountryapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.system.exitProcess


class MainViewModel: ViewModel() {

    var nbVisitor: MutableLiveData<Int> = MutableLiveData(0)
    var rnds: MutableLiveData<Int> = MutableLiveData(0)

    fun addVisitor(){
        nbVisitor.value = nbVisitor.value?.plus(1)
        randomNumber()
    }

    fun deleteVisitor(){
        if(nbVisitor.value!! > 0){
            nbVisitor.value = nbVisitor.value?.minus(1)
        }
        randomNumber()
    }

    fun resetCompteur(){
        if(nbVisitor.value!! > 0){
            nbVisitor.value = 0
        }
        randomNumber()
    }

    fun quit(){
        exitProcess(-1)
    }

    fun randomNumber(){
        rnds.value = (0..100).random()
    }




}