const readline = require("readline");

let cnt = 0;

function checkAge(age) {
  cnt++;
  if (cnt === 3) r1.close(); // 3번째 입력 후 인터페이스 종료
  return age > 19; // 19세 초과 여부
}

const r1 = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});


function askForAge() {

    r1.question("Input age: ", (data) => {
      const age = parseInt(data, 10); // 입력된 값을 정수로 변환
      if (isNaN(age)) {
        console.log("유효한 나이를 입력하세요."); // 나이가 유효하지 않을 경우
      } else {
        if (checkAge(age)) {
          console.log("pass");
        } else {
          console.log("not pass");
        }
      }
      if(cnt<3) askForAge(); // 다음 입력 요청
    });
}

askForAge(); // 최초 입력 요청



