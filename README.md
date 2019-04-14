# Packer
This API calculate the best package option with given constraints. There are some samples in resources file 

# What I used
- Java 8, Lambda expressions
- JUnit 5
- TDD approaching

# Arcitecture
API consisting of four main part which in one core method named Packer. All parts below;
- FileReader: reads lines from file
- PackageGenerator: generates items and package from each line.There is a limitation about weight in this step.
- PackageCalculator: calculates every possiblility of packaging from givem items. There is also some limitations about item weight and cost.
returns best option for packaging. There is a tree map algorithm here. Each possibility is a node.
- ResultBoard: shows and return results as wanted.

There is no a lot of comment. Because I try to write code with high readebility.If there are missunderstanding parts I prefer 
to write more readability code instead of adding comments.

I use TDD aproaching. There are plenty of test cases.
