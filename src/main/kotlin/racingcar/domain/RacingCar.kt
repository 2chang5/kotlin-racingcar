package racingcar.domain

import racingcar.constant.STATE_UNIT

class RacingCar(
    private val name: String,
    private var movingState: Int = 0,
) : Comparable<RacingCar> {
    fun moveForward() {
        movingState += 1
    }

    fun getStateProgress(): String {
        var value = ""
        for (i in 0 until movingState) {
            value += STATE_UNIT
        }
        return value
    }

    override fun toString(): String = "$name : ${getStateProgress()}"

    override fun compareTo(other: RacingCar): Int {
        return if (this.movingState >= other.movingState) 1 else -1
    }
}
