package machucapps.com.cryptocurrencyapp.presentation.coin_detail

import machucapps.com.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)