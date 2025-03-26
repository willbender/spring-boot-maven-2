package com.twenty3.sbmaven;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomNumberController {

    /**
     * Generates an array of random integers.
     *
     * @param number the number of random integers to generate
     * @return an array containing the generated random integers
     */
    @GetMapping("/random")
    public int[] getRandomNumbers(@RequestParam int number) {
        Random random = new Random();
        int[] randomNumbers = new int[number];
        for (int i = 0; i < number; i++) {
            randomNumbers[i] = random.nextInt();
        }
        return randomNumbers;
    }
}