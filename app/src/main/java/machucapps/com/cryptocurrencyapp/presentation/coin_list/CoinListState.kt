package machucapps.com.cryptocurrencyapp.presentation.coin_list

import machucapps.com.cryptocurrencyapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)