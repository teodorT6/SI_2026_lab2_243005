# **Втора лабараториска вежба по Софтверско инженерство**

Теодор Трајковски 243005

### Control Flow Graph

#### searchBookByTitle

<img width="539" height="362" alt="CFG 1" src="https://github.com/user-attachments/assets/eb0f7320-219a-45b1-87e4-8e601cdd74cd" />


#### borrowBook

<img width="460" height="596" alt="Graph2" src="https://github.com/user-attachments/assets/94995199-d994-4634-ba27-d556137ec55c" />

### Цикломатска комплексност

Цикломатската комплексност за searchBookByTitle e 5, истата ја добив
преку формулата P+1, каде што P е бројот на предикатни јазли.
Во случајов P=4, па цикломатската комплексност изнесува 5.

Цикломатската комплексност за borrowBook е 5, истата ја добив преку формулата P+1,
каде што P е бројот на предикатни јазли.
Во случајов P=4, па цикломатската комплексност изнесува 5.

### Тест случаи според критериумот Every statement

|       | test1 | test2 | test3 |
|-------|-------|-------|-------|
| line1 | *     | *     | *     |
| line2 | *     |       |       |
| line3 |       | *     | *     |
| line4 |       | *     | *     |
| line5 |       | *     | *     |
| line6 |       | *     |       |
| line7 |       | *     | *     |
| line8 |       |       | *     |
| line9 |       | *     |       |
|line10 |*      | *     | *     |
- test1: празен title ќе се фрла исклучок `IllegalArgumentException`
- test2: Clean Code книгата е пронајдена и не е позајмена се враќа листа
- test3: Harry Potter книгата не е пронајдена се враќа null

Минималниот број на тест случаи за да се исполни Every Statement критериумот за функцијата `searchBookByTitle` е 3.

### Тест случаи според критериумот Every branch

|           | test1 | test2 | test3 | test4 |
|-----------|-------|-------|-------|-------|
| branch1 T | *     |       |       |       |
| branch1 F |       | *     | *     | *     |
| branch2 T |       | *     | *     |       |
| branch2 F |       | *     |       |       |
| branch3 T |       |       | *     |       |
| branch3 F |       |       |       | *     |

- test1: празен title и author затоа се фрла исклучок `IllegalArgumentException`
- test2: The Hobbit и J.R.R. Tolkien книгата постои и не е позајмена успешно се позајмува
- test3: The Hobbit и J.R.R. Tolkien книгата постои, но веќе е позајмена се фрла `RuntimeException`
- test4: Unknown и Someone книгата не постои → се фрла `RuntimeException`

Минималниот број на тест случаи за да се исполни Every Branch критериумот за функцијата `borrowBook` е 4.

### Тест случаи според критериумот Multiple condition

#### borrowBook

| | test |
|----------------|---|
| TX             | test1: `borrowBook("", "J.R.R. Tolkien")` |
| FT             | test2: `borrowBook("The Hobbit", "")` |
| FF             | test3: `borrowBook("The Hobbit", "J.R.R. Tolkien")` |

### Објаснување

- test1: title е празен условот но author има па условот е true и се фрла исклучок тука без разлика што и да е второто ако првото е true секогаш функцијата е true
- test2: title има но author е празен условот е true се фрла исклучок
- test3: title и author не се празни па условот е false функцијата продолжува нормално

Минимален број на тест случаи за `borrowBook` според Multiple condition критериумот е 3.

---

#### searchBookByTitle

|   | test |
|---|---|
| TT |test1: `searchBookByTitle("Clean Code")` |
| TF | test2: `searchBookByTitle("Clean Code")`, каде книгата е позајмена |
| FX |test3: `searchBookByTitle("Unknown")` |

- test1: title се совпаѓа и книгата не е позајмена двете се true  книгата се додава во results
- test2: title се совпаѓа но книгата е позајмена па не се додава
- test3: првиот услов е false а другиот без разлика дали е true или false не се додава

Минимален број на тест случаи за `searchBookByTitle` според Multiple condition критериумот е 3.
