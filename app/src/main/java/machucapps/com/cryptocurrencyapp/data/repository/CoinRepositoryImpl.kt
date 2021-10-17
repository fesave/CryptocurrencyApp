package machucapps.com.cryptocurrencyapp.data.repository

import machucapps.com.cryptocurrencyapp.data.remote.CoinPaprikaApi
import machucapps.com.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import machucapps.com.cryptocurrencyapp.data.remote.dto.CoinDto
import machucapps.com.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId = coinId)
    }
}