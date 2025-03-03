package com.example.middlecourseproject.domain

interface StringProvider {
    fun getString(resId: Int): String
    fun getString(resId: Int, vararg formatArgs: Any): String
}