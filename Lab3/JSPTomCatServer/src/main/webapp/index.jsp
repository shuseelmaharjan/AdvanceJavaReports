<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Greatest Number Finder</title>
</head>
<body>
    <h2>Find the Greatest Number</h2>
    <form action="index.jsp" method="post">
        <label for="num1">Number 1:</label>
        <input type="text" id="num1" name="num1" required>
        <br><br>
        <label for="num2">Number 2:</label>
        <input type="text" id="num2" name="num2" required>
        <br><br>
        <label for="num3">Number 3:</label>
        <input type="text" id="num3" name="num3" required>
        <br><br>
        <input type="submit" value="Find Greatest">
    </form>

    <%
        // Retrieve numbers from the request
        String num1Str = request.getParameter("num1");
        String num2Str = request.getParameter("num2");
        String num3Str = request.getParameter("num3");

        if (num1Str != null && num2Str != null && num3Str != null) {
            try {
                // Convert input strings to integers
                int num1 = Integer.parseInt(num1Str);
                int num2 = Integer.parseInt(num2Str);
                int num3 = Integer.parseInt(num3Str);

                // Find the greatest number
                int greatest = num1;
                if (num2 > greatest) {
                    greatest = num2;
                }
                if (num3 > greatest) {
                    greatest = num3;
                }

                // Display the result
                out.println("<h3>The greatest number is: " + greatest + "</h3>");
            } catch (NumberFormatException e) {
                out.println("<h3>Please enter valid numbers.</h3>");
            }
        }
    %>
</body>
</html>
