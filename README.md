# cp-stats

A competitive programming information tools.

## What is cp-stats?
     Loading ....
### Input File Structure

 - [Codeforces user handle](https://github.com/Saikat-S/uva-stats/blob/master/file/input_file/codeforces_user_handle.txt)
 - [Uva user name](https://github.com/Saikat-S/uva-stats/blob/master/file/input_file/uva_user_name.txt)
 - [Female user Uva user name](https://github.com/Saikat-S/uva-stats/blob/master/file/input_file/female_uva_user.txt)
 - [Junior user Uva user name](https://github.com/Saikat-S/uva-stats/blob/master/file/input_file/junior_uva_user.txt)

#### Demo Structure

Uva and Codeforces user name

| nth Batch |
|-----------|
|   user1   |
|   user2   |
|     .     |
|   userN   |
|**n-1th Batch**|
|   user1   |
|   user2   |
|     .     |
|   userN   |


**nth Batch** means that the below users are from **nth** batch.


### Output File Structure
Output is two part one part is all user information and other part is top five user information.
 - [All User Information](https://github.com/Saikat-S/uva-stats/tree/master/file/all_user_info)
   - [Codeforces rating](https://github.com/Saikat-S/uva-stats/blob/master/file/all_user_info/codeforces_user_rating.txt)
   - [Uva total solve](https://github.com/Saikat-S/uva-stats/blob/master/file/all_user_info/uva_user_solve.txt)
   - [Female user Uva total solve](https://github.com/Saikat-S/uva-stats/blob/master/file/all_user_info/female_uva_solve.txt)
   - [Junior user Uva total solve](https://github.com/Saikat-S/uva-stats/blob/master/file/all_user_info/junior_uva_solve.txt)
 - [Top Five User](https://github.com/Saikat-S/uva-stats/tree/master/file/output_file)
    - [Coderforces top five user](https://github.com/Saikat-S/uva-stats/blob/master/file/output_file/codeforces_top_five.txt)
    - [Uva top five user](https://github.com/Saikat-S/uva-stats/blob/master/file/output_file/uva_top_five.txt)
    -  [Female top five Uva user](https://github.com/Saikat-S/uva-stats/blob/master/file/output_file/female_uva_top_five.txt)
    -  [Junior top five Uva user](https://github.com/Saikat-S/uva-stats/blob/master/file/output_file/junior_uva_top_five.txt)

#### Demo Structure

Uva User

| User Name | Total Solve |
|-----------|-------------|
|   user1   |     a      |
|   user2   |     b       |
|   user3   |     c       |
|   user4   |     d       |
|   user5   |     e       |
|     .     |     .       |
|   userN   |     z       |

Top Five Uva User

| User Name | Total Solve |
|-----------|-------------|
|   user1   |     a       |
|   user2   |     b       |
|   user3   |     c       |
|   user4   |     d       |
|   user5   |     e       |

Codeforces User

| User Name | Rating | Number of Contest |
|-----------|--------|-------------------|
|   user1   |   x1   |       y1          |
|   user2   |   x2   |       y2          | 
|   user3   |   x3   |       y3          |
|   user4   |   x4   |       y4          |
|   user5   |   x5   |       y5          |
|     .     |   .    |       .           |
|   userN   |   xN   |       yN          |

Top Five Codeforces User

| User Name | Rating | Number of Contest |
|-----------|--------|-------------------|
|   user1   |   x1   |       y1          |
|   user2   |   x2   |       y2          | 
|   user3   |   x3   |       y3          |
|   user4   |   x4   |       y4          |
|   user5   |   x5   |       y5          |





### Installation

 > Clone the Repository

```sh
$ git clone https://github.com/Saikat-S/uva-stats
```
 
 > Open the project with IntelliJ and add the [jar](https://github.com/Saikat-S/uva-stats/blob/master/lib/java-json.jar) file in class path.
 > Then run the project and now you get your output file in 
     
     uva-stats/file/output/here.txt

### Licence
MIT
