#!/usr/bin/env bash

apidoc --input src/ -o build/apidoc --parse-languages java && serve -s build/apidoc

apidoc --input devops/doc-zh -o build/apidoc-zh --parse-languages js && serve -s build/apidoc-zh

