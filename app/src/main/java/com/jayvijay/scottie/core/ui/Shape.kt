package com.jayvijay.scottie.core.ui

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

/**
 * Standalone Material 3 shape tokens aligned with the Stitch Autonomous Banking Experience:
 * - extraSmall (4.dp): Inline code badges and micro indicators
 * - small (8.dp): Base components, checkboxes, segmented buttons, inline chips
 * - medium (12.dp): Input fields, search bars, nested sub-containers
 * - large (16.dp): Interactive controls, action buttons, transaction line items
 * - extraLarge (24.dp): A2UI dynamic chat cards, transfer slips, model download cards
 */
val ScottieShapes =
  Shapes(
    extraSmall = RoundedCornerShape(4.dp),
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(12.dp),
    large = RoundedCornerShape(16.dp),
    extraLarge = RoundedCornerShape(24.dp),
  )
