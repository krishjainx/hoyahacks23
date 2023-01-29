package com.ezyretirement.app.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ezyretirement.app.models.PersonalData

class UserDataViewModel :ViewModel() {
    private val data = MutableLiveData<PersonalData>()


    fun setData(personalData:PersonalData){
        data.value = personalData
    }

    fun getData() :MutableLiveData<PersonalData>{
        return data
    }

}