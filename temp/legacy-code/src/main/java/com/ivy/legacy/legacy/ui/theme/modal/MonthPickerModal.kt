package com.ivy.wallet.ui.theme.modal

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ivy.design.l0_system.UI
import com.ivy.design.l0_system.style
import com.ivy.legacy.IvyWalletPreview
import com.ivy.legacy.data.model.Month.Companion.monthsList
import com.ivy.legacy.utils.dateNowUTC
import com.ivy.legacy.utils.drawColoredShadow
import com.ivy.legacy.utils.hideKeyboard
import com.ivy.legacy.utils.onScreenStart
import com.ivy.design.utils.thenIf
import com.ivy.ui.R
import com.ivy.wallet.ui.theme.Gradient
import com.ivy.wallet.ui.theme.Ivy
import com.ivy.wallet.ui.theme.components.WrapContentRow
import com.ivy.wallet.ui.theme.findContrastTextColor
import java.time.LocalDate
import java.util.UUID

@Deprecated("Old design system. Use `:ivy-design` and Material3")
@Composable
fun BoxWithConstraintsScope.MonthPickerModal(
    id: UUID = UUID.randomUUID(),
    initialDate: LocalDate,
    visible: Boolean,
    dismiss: () -> Unit,
    onMonthSelected: (Int) -> Unit
) {
    var selectedMonth by remember {
        mutableStateOf(initialDate.monthValue)
    }

    IvyModal(
        id = id,
        visible = visible,
        dismiss = dismiss,
        PrimaryAction = {
            ModalSave {
                onMonthSelected(selectedMonth)
                dismiss()
            }
        }
    ) {
        val view = LocalView.current
        onScreenStart {
            hideKeyboard(view)
        }

        Spacer(Modifier.height(32.dp))

        ModalTitle(
            text = stringResource(R.string.choose_month)
        )

        Spacer(Modifier.height(24.dp))

        MonthPicker(
            selectedMonth = selectedMonth,
            onMonthSelected = {
                selectedMonth = it
            }
        )

        Spacer(Modifier.height(56.dp))
    }
}

@Composable
private fun MonthPicker(
    selectedMonth: Int,
    onMonthSelected: (Int) -> Unit
) {
    val months = monthsList()

    WrapContentRow(
        modifier = Modifier
            .padding(horizontal = 16.dp),
        horizontalMarginBetweenItems = 12.dp,
        verticalMarginBetweenRows = 12.dp,
        items = months
    ) {
        MonthButton(
            month = it,
            selected = it.monthValue == selectedMonth
        ) {
            onMonthSelected(it.monthValue)
        }
    }
}

@Composable
private fun MonthButton(
    month: com.ivy.legacy.data.model.Month,
    selected: Boolean,
    onClick: () -> Unit,
) {
    val monthColor = Ivy

    val medium = UI.colors.medium
    val rFull = UI.shapes.rFull

    Text(
        modifier = Modifier
            .thenIf(selected) {
                drawColoredShadow(monthColor)
            }
            .clip(UI.shapes.rFull)
            .clickable(onClick = onClick)
            .thenIf(!selected) {
                border(2.dp, medium, rFull)
            }
            .thenIf(selected) {
                background(
                    brush = Gradient
                        .solid(monthColor)
                        .asHorizontalBrush(),
                    rFull
                )
            }
            .padding(horizontal = 40.dp, vertical = 12.dp),
        text = month.name,
        style = UI.typo.b2.style(
            color = if (selected) {
                findContrastTextColor(monthColor)
            } else {
                UI.colors.pureInverse
            },
            fontWeight = FontWeight.SemiBold
        )
    )
}

@Preview
@Composable
private fun Preview() {
    IvyWalletPreview {
        MonthPickerModal(
            initialDate = dateNowUTC(),
            visible = true,
            dismiss = {}
        ) {
        }
    }
}
