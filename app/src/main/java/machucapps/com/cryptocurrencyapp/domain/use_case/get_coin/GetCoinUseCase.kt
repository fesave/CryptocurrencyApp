package machucapps.com.cryptocurrencyapp.domain.use_case.get_coin

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import machucapps.com.cryptocurrencyapp.common.Resource
import machucapps.com.cryptocurrencyapp.data.remote.dto.toCoin
import machucapps.com.cryptocurrencyapp.data.remote.dto.toCoinDetail
import machucapps.com.cryptocurrencyapp.domain.model.Coin
import machucapps.com.cryptocurrencyapp.domain.model.CoinDetail
import machucapps.com.cryptocurrencyapp.domain.repository.CoinRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    suspend operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> =
        repository.getCoinById(coinId = coinId)
}