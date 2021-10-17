package machucapps.com.cryptocurrencyapp.domain.use_case.get_coins

import kotlinx.coroutines.flow.Flow
import machucapps.com.cryptocurrencyapp.common.Resource
import machucapps.com.cryptocurrencyapp.domain.model.Coin
import machucapps.com.cryptocurrencyapp.domain.repository.CoinRepository

import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<Coin>>> = repository.getCoins()
}