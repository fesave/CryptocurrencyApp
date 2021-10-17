package machucapps.com.cryptocurrencyapp.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import machucapps.com.cryptocurrencyapp.common.Constants
import machucapps.com.cryptocurrencyapp.common.Resource
import machucapps.com.cryptocurrencyapp.domain.use_case.get_coin.GetCoinUseCase
import machucapps.com.cryptocurrencyapp.domain.use_case.get_coins.GetCoinsUseCase
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf<CoinDetailState>(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getCoin(coinId = coinId)
        }
    }

    private fun getCoin(coinId: String) {
        getCoinsUseCase(coinId = coinId).onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _state.value =
                        CoinDetailState(error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = CoinDetailState(coin = result.data)
                }
            }
        }.launchIn(viewModelScope)
    }

}