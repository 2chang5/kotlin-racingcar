package racingcar.domain

import racingcar.constant.STANDARD_OF_MOVING
import racingcar.domain.numbergenerator.NumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingGame(
    private val generator: NumberGenerator,
    private val referee: Referee,
) {
    fun runGame() {
        val names = getCarsName()
        val roundCount = getRoundCount()
        val cars = mutableListOf<RacingCar>()
        names.forEach { cars.add(RacingCar(it)) }

        OutputView.printResult()
        for (i in 0 until roundCount) {
            playRound(cars)
        }

        OutputView.printWinner(referee.getWinner(cars))
    }

    fun playRound(cars: MutableList<RacingCar>) {
        cars.forEach {
            play(it)
        }
        OutputView.printEachRound(cars)
    }

    fun play(car: RacingCar) {
        if (checkGoingForward(generator.generate())) {
            car.moveForward()
        }
    }

    fun getCarsName(): List<String> {
        return InputView.getCarsName { OutputView.printGettingCarsName() }
    }

    fun getRoundCount(): Int {
        return InputView.getRoundCount { OutputView.printGettingRoundCount() }
    }

    fun checkGoingForward(randomNumber: Int): Boolean = randomNumber >= STANDARD_OF_MOVING
}
