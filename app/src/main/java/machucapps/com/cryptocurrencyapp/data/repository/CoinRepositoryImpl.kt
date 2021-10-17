package machucapps.com.cryptocurrencyapp.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import machucapps.com.cryptocurrencyapp.common.Resource
import machucapps.com.cryptocurrencyapp.data.remote.CoinPaprikaApi
import machucapps.com.cryptocurrencyapp.data.remote.dto.toCoin
import machucapps.com.cryptocurrencyapp.data.remote.dto.toCoinDetail
import machucapps.com.cryptocurrencyapp.domain.model.Coin
import machucapps.com.cryptocurrencyapp.domain.model.CoinDetail
import machucapps.com.cryptocurrencyapp.domain.repository.CoinRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override fun getCoins(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = api.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }

    override fun getCoinById(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = api.getCoinById(coinId = coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}