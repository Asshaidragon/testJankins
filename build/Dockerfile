FROM python:3.10

COPY /build/requirements.txt /code/
RUN pip install --upgrade pip && pip install -r /code/requirements.txt && rm /code/requirements.txt

COPY /test /code/test

WORKDIR /code