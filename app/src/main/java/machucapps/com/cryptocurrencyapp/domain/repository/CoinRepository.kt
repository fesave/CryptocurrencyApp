package machucapps.com.cryptocurrencyapp.domain.repository

import kotlinx.coroutines.flow.Flow
import machucapps.com.cryptocurrencyapp.common.Resource
import machucapps.com.cryptocurrencyapp.domain.model.Coin
import machucapps.com.cryptocurrencyapp.domain.model.CoinDetail

interface CoinRepository {

     fun getCoins(): Flow<Resource<List<Coin>>>
     fun getCoinById(coinId: String): Flow<Resource<CoinDetail>>
}