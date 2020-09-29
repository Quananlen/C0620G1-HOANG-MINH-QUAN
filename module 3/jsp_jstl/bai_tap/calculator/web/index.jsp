<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>
      <h1>Simple calculator</h1>
      <form action="/calculator" onsubmit="return validate()">
        <fieldset>
          <legend>Calculator</legend>
          <label for="fo">First Operand</label>
          <input type="text" id="fo" name="fo" onblur="validateNumber('fo')" required><br><br>
          <label for="operator">Operator</label>
          <select name="operator" id="operator">
            <option value="addition">addition</option>
            <option value="subtraction">subtraction</option>
            <option value="multiplication">multiplication</option>
            <option value="division">division</option>
          </select><br><br>
          <label for="so">Second operand</label>
          <input type="text" id="so" name="so" onblur="validateNumber('so')" required><br><br>
          <input type="submit" id="submit" value="Calculate">
        </fieldset>
      </form>
      <div style="color: red" id="alert"></div>
      <c:out value="${result}"></c:out>
      <script>
          function validateNumber(id) {
              document.getElementById("alert").innerText = "";
              let input = document.getElementById(id);
              let regex = /\d+/;
              if (!regex.test(input.value) && input.value !== "") {
                  document.getElementById("alert").innerText = "please input number";
                  input.value = "";
              }
          }
          function validate() {
              document.getElementById("submit").addEventListener("click", function(event){
                  event.preventDefault()
              });
              let num1 = document.getElementById("fo");
              let num2 = document.getElementById("so");
              let regex = /\d+/;
              if (!regex.test(num1.value) || !regex.test(num2.value)) {
                  alert("please input number");
                  return false;
              }
          }
      </script>
  </body>
</html>
