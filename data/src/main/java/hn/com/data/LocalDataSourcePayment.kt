package hn.com.data

interface LocalDataSourcePayment{
    suspend fun calculatePayment(time:Int,price:Double):Double{
        return time * price;
    }
}