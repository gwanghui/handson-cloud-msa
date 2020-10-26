FROM python:3.8-alpine
ADD ./requirements.txt .
RUN pip install -r requirements.txt
COPY . .

EXPOSE 8093
CMD ["sh", "-c", "gunicorn -b 0.0.0.0:8093 app:app --access-logfile - --error-logfile -"]