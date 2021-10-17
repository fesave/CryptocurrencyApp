package machucapps.com.cryptocurrencyapp.domain.repository

import machucapps.com.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import machucapps.com.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}