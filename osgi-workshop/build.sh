#!/usr/bin/env bash
set -euo pipefail

MODE="${1:-changed}"
shift || true

python3 "$(dirname "$0")/smart-build.py" --mode "$MODE" "$@"